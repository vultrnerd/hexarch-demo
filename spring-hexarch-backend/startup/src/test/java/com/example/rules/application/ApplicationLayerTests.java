package com.example.rules.application;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;

@AnalyzeClasses(packages = "com.example.application", importOptions = {ImportOption.DoNotIncludeTests.class})
public class ApplicationLayerTests {

    @ArchTest
    public static final ArchTests APPLICATION_LAYER_RULES = ArchTests.in(ApplicationLayerRules.class);

    @ArchTest
    public static final ArchTests APPLICATION_USECASE_RULES = ArchTests.in(UseCaseRules.class);

}
