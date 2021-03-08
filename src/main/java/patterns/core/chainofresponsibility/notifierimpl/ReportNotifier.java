package patterns.core.chainofresponsibility.notifierimpl;

import patterns.core.chainofresponsibility.Notifier;

public class ReportNotifier extends Notifier {
    public ReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Report: " + message);
    }
}
