 E2_automation_framework_skeleton:
- Task 3;
- Reflection.

   ## Task 3:

Develop a small automation framework skeleton using the Java one as example.
Use Page object pattern as base, and try to integrate BDD approach. use Junit, Nunit for your base. And Selenium as engine.

To run the "Task 3", you need:

- run this command: run this command: mvn clean test -Dcucumber.filter.tags="@skeleton" (you will use default webDriver - chrome);

- if not chrome webDriver will be use, in order to change webDriver you have to add
property "-Dbrowser=firefox". At the moment chrome and firefox are supported.

  ## Reflection:

To run the "Reflection", you need:
- run this command: mvn clean test -Dcucumber.filter.tags="@reflection".