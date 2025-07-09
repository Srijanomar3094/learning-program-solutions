package com.cognizant.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemo {
    public static void main(String[] args) {
        System.out.println("=== Spring Beans Lifecycle Demo ===");
        
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
        
        System.out.println("\n--- Getting Singleton Bean ---");
        LifecycleBean singletonBean1 = context.getBean("singletonBean", LifecycleBean.class);
        LifecycleBean singletonBean2 = context.getBean("singletonBean", LifecycleBean.class);
        
        System.out.println("Singleton Bean 1: " + singletonBean1);
        System.out.println("Singleton Bean 2: " + singletonBean2);
        System.out.println("Are they the same instance? " + (singletonBean1 == singletonBean2));
        
        System.out.println("\n--- Getting Prototype Bean ---");
        LifecycleBean prototypeBean1 = context.getBean("prototypeBean", LifecycleBean.class);
        LifecycleBean prototypeBean2 = context.getBean("prototypeBean", LifecycleBean.class);
        
        System.out.println("Prototype Bean 1: " + prototypeBean1);
        System.out.println("Prototype Bean 2: " + prototypeBean2);
        System.out.println("Are they the same instance? " + (prototypeBean1 == prototypeBean2));
        
        System.out.println("\n--- Demonstrating Bean Methods ---");
        singletonBean1.performAction();
        prototypeBean1.performAction();
        
        // Close the context to trigger destroy methods
        System.out.println("\n--- Closing Application Context ---");
        ((ClassPathXmlApplicationContext) context).close();
        
        System.out.println("=== Spring Beans Lifecycle Demo Complete ===");
    }
} 