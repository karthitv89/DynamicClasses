package de.bertilmuth.javadataclass.model;

import java.util.Collections;
import java.util.List;

public class ClassSpecification {
    public void setName(String name) {
        this.name = name;
    }

    public String getSwiftPattern() {
        return swiftPattern;
    }

    public void setSwiftPattern(String swiftPattern) {
        this.swiftPattern = swiftPattern;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

    public void setRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    private String name;
    private String swiftPattern;
    private String regexPattern;
    private List<FieldSpecification> fieldSpecifications;

    public ClassSpecification(String className, String swiftPattern, String regexPattern) {
        this.name = className;
        this.swiftPattern = swiftPattern;
        this.regexPattern = regexPattern;
    }

    public String getName() {
        return name;
    }

    public List<FieldSpecification> getFieldSpecifications() {
        return Collections.unmodifiableList(fieldSpecifications);
    }

    @Override
    public String toString() {
        return "ClassSpecification{" +
                "name='" + name + '\'' +
                ", swiftPattern='" + swiftPattern + '\'' +
                ", regexPattern='" + regexPattern + '\'' +
                '}';
    }
}
