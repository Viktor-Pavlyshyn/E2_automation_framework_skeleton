package patterns.main;

import patterns.core.template.Job;
import patterns.core.template.Template;

public class TemplateTest {
    public static void main(String[] args) {
        Template template = new Job();
        template.templateMethod();
    }
}
