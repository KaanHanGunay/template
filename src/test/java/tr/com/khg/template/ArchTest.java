package tr.com.khg.template;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tr.com.khg.template");

        noClasses()
            .that()
            .resideInAnyPackage("tr.com.khg.template.service..")
            .or()
            .resideInAnyPackage("tr.com.khg.template.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..tr.com.khg.template.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
