package patterns.main;

import patterns.core.chainofresponsibility.Notifier;
import patterns.core.chainofresponsibility.notifierimpl.EmailNotifier;
import patterns.core.chainofresponsibility.notifierimpl.ReportNotifier;

import static patterns.core.chainofresponsibility.Priority.*;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Notifier reportNotifier = new ReportNotifier(ROUTINE.getLevel());
        Notifier emailNotifier = new EmailNotifier(IMPORTANT.getLevel());
        Notifier smsNotifier = new ReportNotifier(ASAP.getLevel());

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK.", ROUTINE.getLevel());
        reportNotifier.notifyManager("Something went wrong.", IMPORTANT.getLevel());
        reportNotifier.notifyManager("Big problem.", ASAP.getLevel());
    }
}
