# CODEBUDDY.md

This file provides guidance to CodeBuddy Code when working with code in this repository.

## What this repo is

A personal, chapter-by-chapter Java study repo following 廖雪峰's Java tutorial. It is a scratchpad of runnable snippets, not a library or an application — no file depends on any other file.

## Prerequisites

A JDK is **not** on `PATH` and `JAVA_HOME` is unset in the current environment. Check before compiling:

```bash
java -version   # currently: command not found
```

If absent, install a JDK (Temurin 21 works — all code here is plain Java 8-era syntax) and add its `bin` to `PATH`.

## Build & run

No Maven, Gradle, `pom.xml`, `build.gradle`, linter, or test framework. Everything is `javac` + `java`.

Compile and run one file:

```bash
javac 01-basics/array/Array.java
java -cp 01-basics/array Array
```

Classes are in the default package, so the containing directory must be passed via `-cp` (or `cd` into it and run `javac Array.java && java Array`).

Compile everything at once:

```bash
javac $(find . -name '*.java')
```

The only program that reads `args` is `CommandLineArguments`; it prints a usage line and returns unless given exactly two integers:

```bash
java -cp 01-basics/array CommandLineArguments 3 5   # prints 8
```

## How "tests" work here

There is no JUnit. Verification is inline in `main`: the program prints its result, compares against a hardcoded expected value, and prints `Test passed` / `Test failed`. Examples: `01-basics/array/SortDescending.java:19` compares a stringified array; `01-basics/array/TwoDimensionalArrays.java:31` uses an epsilon compare for the floating-point average.

So "run the tests" means: compile the file, run it, confirm stdout ends with `Test passed`. When adding an exercise with a verifiable answer, follow this same pattern instead of introducing a test framework.

## Layout

Top-level directories are numbered by tutorial section. Each subdirectory is one topic containing standalone `.java` files plus a `README-<topic>.md` of tutorial notes.

```
01-basics/array/          # Array, CommandLineArguments, Sortascending, SortDescending,
                          # TwoDimensionalArrays + README-array.md
02-oop/classes-objects/   # PrimitiveParamBinding, ArrayParamBinding, StringParamBinding
                          # + README-class-object.md
```

Run the 02-oop demos the same way as 01-basics:

```bash
javac 02-oop/classes-objects/PrimitiveParamBinding.java
java -cp 02-oop/classes-objects PrimitiveParamBinding
```

Conventions that hold throughout:

- **One file = one self-contained demo.** Each declares a single top-level class with `public static void main(String[] args)`. Nothing is shared between files — copy the few lines rather than adding a shared utility class.
- **Filename must equal the public class name** (Java requirement). `Sortascending.java` breaks the PascalCase convention the other files follow; keep new files PascalCase and match existing names when editing.
- **No package declarations.** That is why `java -cp <dir>` is required, and why two files in a topic directory cannot declare the same non-public helper class name — the three `Person` classes in `02-oop/` are named `PersonWithAge`, `PersonWithFullName`, and `PersonWithName` for exactly this reason.
- **Comments mix Chinese and English.** `README-array.md` and most `.java` comments are Chinese notes from the tutorial; `Array.java` is commented in English. Match the language of the file you are editing.
- **No `.gitignore`,** so `javac` output (`.class`) is picked up by `git status` and some is already committed. Don't commit new `.class` files.
- **Each topic directory carries a `README-<topic>.md`** of Chinese tutorial notes, structured like `01-basics/array/README-array.md`: `#` topic title, `##` sections, `###` one takeaway per bullet, then fenced code blocks and ASCII box diagrams. Add notes there rather than creating a new doc.

## Git state

Single commit (`Initial commit`) on `main`, containing only `01-basics/`. Everything under `02-oop/`, plus `CODEBUDDY.md` itself, is untracked — nothing there is recoverable from git if deleted.
