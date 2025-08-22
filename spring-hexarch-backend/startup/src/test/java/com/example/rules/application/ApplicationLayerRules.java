package com.example.rules.application;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ApplicationLayerRules {

    @ArchTest
    public static final ArchRule APPLICATION_SHOULD_NOT_DEPEND_ON_INFRASTRUCTURE_RULE = noClasses()
            .that()
            .resideInAPackage("..application..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..infrastructure..")
            .because("Application layer should not depend on infrastructure layers directly.");

    @ArchTest
    public static final ArchRule APPLICATION_CLASSES_SHOULD_BE_INSIDE_USECASES_OR_MAPPERS_RULE = noClasses()
            .should()
            .resideOutsideOfPackages("..usecases..", "..mappers..")
            .because("Application classes should be use cases or mappers.");

}
