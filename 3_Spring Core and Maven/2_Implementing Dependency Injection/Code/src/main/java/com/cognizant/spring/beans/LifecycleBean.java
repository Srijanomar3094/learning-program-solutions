package com.cognizant.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleBean implements InitializingBean, DisposableBean {
    private String name;
    private int id;
    
    public LifecycleBean() {
        System.out.println("LifecycleBean: Constructor called");
    }
    
    public void setName(String name) {
        this.name = name;
        System.out.println("LifecycleBean: setName() called with: " + name);
    }
    
    public void setId(int id) {
        this.id = id;
        System.out.println("LifecycleBean: setId() called with: " + id);
    }
    
    // InitializingBean interface method
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleBean: afterPropertiesSet() called");
    }
    
    // DisposableBean interface method
    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleBean: destroy() called");
    }
    
    // Custom init method
    public void customInit() {
        System.out.println("LifecycleBean: customInit() called");
    }
    
    // Custom destroy method
    public void customDestroy() {
        System.out.println("LifecycleBean: customDestroy() called");
    }
    
    public void performAction() {
        System.out.println("LifecycleBean: performAction() called - Name: " + name + ", ID: " + id);
    }
    
    @Override
    public String toString() {
        return "LifecycleBean{name='" + name + "', id=" + id + ", hashCode=" + hashCode() + "}";
    }
} 