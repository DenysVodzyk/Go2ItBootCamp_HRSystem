Task description:

You are asked to develop a system for the HR department that will manage all the
employees.

Requirements:
- Each employee of the company has a profile in the system. It includes, in particular,
role description, name, DoB, department.
- Each department should have a list of all employees working there. One employee
can work only in one department ( one-to-one relation).
- An employee can move between departments.
- Annual reviews:
    - Annual salary review for an employee will be based on
different factors (years of experience, number of sales completed, meeting
expectations level, etc.) and the amount will differ.
    - Each employee will have a history of this annual reviews: date, what
manager approved it, salary increase/decrease in % (create a separate
object to store this data).
- Hiring or firing:
    - When an employee joins the company, the profile should be created and
stored in the system.
    - An employee can be fired or quit the company. If the employee is fired, he/she
will get 40% of a current salary on leaving right away.
    - When an employee leaves a company, his status property is changed to
INACTIVE.
- The system must be able to show all the ACTIVE and INACTIVE employees.