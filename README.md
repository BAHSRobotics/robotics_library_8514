# robotics_library_8514
An Android library with premade functions for use with the FTC Robot Controller App. Contains classes for basic robot functionality including drive systems, arms with varying degrees of motion, lifts, linear motion, sensors, and autonomous functionalities

This is a *collaborative* project, so feel free to make and suggest your own changes, but, when you do make edits, please make your code:

- Polymorphic. If the class `Foo` and the class `Oof` are in the same package, `Foo.do()` and `Oof.do()` should do the same fundemental task. This will make it easier for devs to remember functions and what they do.
- Abstract. If you find yourself rewriting a block of code within this project or within your driver controller project, feel free to abstract that behavior to here! This will make programming the Robot Controller faster and more efficient.
- Documented. Add JavaDocs to your code explaining paramaters and functionality to make the entire codebase understandable to those new to the language or the program
- Scalable. Encapsulate logic following conditionals, functions, and loops with braces in order to allow the easy expansion and editing of the codebase. Make adding code as easy as possible.

Also, as a general rule, ***do not make changes to `master` branch.*** Instead, create a new branch and any changes will be merged into master by the Admins

***If a change is rejected, check to make sure your code follows the above rules.*** Also be sure to check feedback given, if any.
