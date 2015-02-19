# clara-test
Reproducing an issue with clara rules compilation

This repo is for illustrating a compilation issue with clara-rules

Check out this project and have maven 3.2.5 installed and run

    mvn compile
    
You should get

    Caused by: java.lang.IllegalArgumentException: clara.examples.shopping/max-discount is not a valid accumulator.
        at clara.rules.compiler$fn__4535$compile_beta_tree__4536$fn__4539$iter__4540__4544$fn__4545$fn__4546.invoke(compiler.clj:840)
        at clara.rules.compiler$fn__4535$compile_beta_tree__4536$fn__4539$iter__4540__4544$fn__4545.invoke(compiler.clj:787)
        at clojure.lang.LazySeq.sval(LazySeq.java:40)
        at clojure.lang.LazySeq.seq(LazySeq.java:49)
        at clojure.lang.RT.seq(RT.java:484)
        at clojure.lang.LazilyPersistentVector.create(LazilyPersistentVector.java:31)
        at clojure.core$vec.invoke(core.clj:356)
        at clara.rules.compiler$fn__4535$compile_beta_tree__4536$fn__4539.invoke(compiler.clj:787)
        at clara.rules.compiler$fn__4535$compile_beta_tree__4536.invoke(compiler.clj:778)
        at clara.rules.compiler$fn__4743$mk_session_STAR___4744$fn__4745.invoke(compiler.clj:987)
        at clara.rules.compiler$fn__4743$mk_session_STAR___4744.invoke(compiler.clj:982)
        at clara.rules.compiler$mk_session.invoke(compiler.clj:1039)
        at clara.examples.shopping$run_examples.invoke(shopping.clj:95)
        at clojure.lang.AFn.applyToHelper(AFn.java:152)
        at clojure.lang.AFn.applyTo(AFn.java:144)
        at clojure.lang.Compiler$InvokeExpr.eval(Compiler.java:3553)
        ... 36 more

Run mvn compile again and you will successfully compile with the output:

    Compiling clara.run-examples to /Users/me/projects/java/ClaraTest/target/classes
    VIP shopping example:
    Summer special and widget promotion example:
    Compiling clara.examples.shopping to /Users/me/projects/java/ClaraTest/target/classes
    VIP shopping example:
    10 % :vip discount
    Summer special and widget promotion example:
    20 % :summer-special discount
    Free :lunch for promotion :free-lunch-with-gizmo
    Free :widget for promotion :free-widget-month
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------



This indicates that the rules fired.


Now try to run the main class defined for the project

mvn exec:java

and you will get

    [INFO] --- exec-maven-plugin:1.2.1:java (default-cli) @ clara-test ---
        VIP shopping example:
        Summer special and widget promotion example:
        Shopping examples:
        VIP shopping example:
        Summer special and widget promotion example:

which indicates that the rules did not fire.
