package com.indeed.forms.builder;

import com.indeed.forms.builder.resource.FormBuilderResource;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("")
public class FormApplication extends javax.ws.rs.core.Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(FormBuilderResource.class);
        return resources;
    }
}
