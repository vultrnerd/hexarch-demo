package com.example.rules.application;

import com.example.shared.annotations.UseCase;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class UseCaseRules {

    @ArchTest
    public static final ArchRule USECASE_SUFFIX_RULE = classes()
            .that()
            .resideInAPackage("..usecases..")
            .and()
            .areAnnotatedWith(UseCase.class)
            .should()
            .haveSimpleNameEndingWith("UseCase")
            .because("Application use cases should have 'UseCase' suffix.");

    @ArchTest
    public static final ArchRule USECASE_SHOULD_IMPLEMENT_INPUT_PORT_RULE = classes()
            .that()
            .resideInAPackage("..usecases..")
            .and()
            .areAnnotatedWith(UseCase.class)
            .should()
            .implement(JavaClass.Predicates.resideInAPackage("..ports.in.."))
            .because("Application use cases should implement an input port interface.");

    @ArchTest
    public static final ArchRule USECASE_FINAL_FIELDS_RULE = classes()
            .that()
            .resideInAPackage("..usecases..")
            .and()
            .areAnnotatedWith(UseCase.class)
            .should()
            .haveOnlyFinalFields()
            .because("Application use cases should have final fields.");

}
