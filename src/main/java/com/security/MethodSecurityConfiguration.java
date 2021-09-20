package com.security;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Autowired
    AutowireCapableBeanFactory  autowireCapableBeanFactory;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        var expressionMetohods = new SecurityMethods();
        autowireCapableBeanFactory.autowireBean(expressionMetohods);
        var expressionHandler = new OAuth2MethodSecurityExpressionHandler(){

            @Override
            public StandardEvaluationContext createEvaluationContextInternal(Authentication authentication, MethodInvocation mi) {
                var result = super.createEvaluationContextInternal(authentication, mi);
                result.setVariable("permissions", expressionMetohods);
                return result;
            }
        };
        return expressionHandler;
    }
}
