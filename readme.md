# Practice

Practicing Data Structures, Algorithms, Concurrency, and more!

## Build and Run

This project uses [Gradle](https://gradle.org/install/). Make sure that you
have [Java](https://java.com/en/download/help/download_options.html) installed.

To run the entire suite of tests:

```
$ ./gradlew test
```

To run a specific test class:

```
$ ./gradlew test --tests <TestClassName>
```

For example, I can run the tests
at [SimpleStackTest](https://github.com/wcygan/Practice/blob/master/src/test/java/io/wcygan/data_structures/stack/SimpleStackTest.java)
with:

```
$ ./gradlew test --tests SimpleStackTest
```

Further, we can a **single** test by specifying its fully qualified path like so:

```
$ gradle test --tests io.wcygan.data_structures.stack.SimpleStackTest.addMany
```

Running any type of test should generate a [JaCoCo](https://github.com/jacoco/jacoco) report file
at `build/jacocoHtml/index.html`
which indicates various types of
[Program Coverage properties](https://www.eclemma.org/userdoc/coverageproperties.html) for the execution of the test
your ran.

## Property-Based Testing with [JUnit-Quickcheck](https://github.com/pholser/junit-quickcheck)

Property-Based Testing allows you to test the programs you write by feeding a program randomly generated inputs.
See [Getting Started with JUnit-Quickcheck](https://pholser.github.io/junit-quickcheck/site/1.0/usage/getting-started.html)
for more details.

Once you've written a property-based test, you can execute it in isolation just as we did before:

```
$ gradle test --tests io.wcygan.QuickCheckTest.testMaze
```

Additionally, this will generate a [JaCoCo](https://github.com/jacoco/jacoco) report file which represents the coverage
observed during the execution of the property-based test.

You can configure the execution of your property-based test using the elements of
the [@Property annotation](https://pholser.github.io/junit-quickcheck/site/1.0/junit-quickcheck-core/apidocs/com/pholser/junit/quickcheck/Property.html)
. For example, you can write `@Property(trials = 10)` to have the test execute 10 times.

## References

I'm using the following material as a reference:

1. [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)
2. [Java Concurrency in Practice](https://jcip.net/)
3. [The Art of Multiprocessor Programming](https://www.oreilly.com/library/view/the-art-of/9780123705914/)
4. [Effective Java](https://www.oreilly.com/library/view/effective-java/9780134686097/)

## Contributing

1. **Fork** the repo on GitHub
2. **Clone** the project to your own machine
3. **Commit** changes to your own branch
4. **Push** your work back up to your fork
5. Submit a **Pull request** for your work

Further, I recommend you use [IntelliJ](https://www.jetbrains.com/idea/) with the
[google-java-format](https://plugins.jetbrains.com/plugin/8527-google-java-format)
plugin to format the code you submit.