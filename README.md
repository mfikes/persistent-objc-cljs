persistent-objc-cljs
====================

A project that compares performance of Anton Astashov's [persistent Obj-C collections](https://github.com/astashov/persistent.objc) with ClojureScript's.

Running
=======

Go into the ClojureScript subdirectory and do a `lein cljsbuild once rel`. Then, you can run the iOS project. If you tap on the "Run Tests" button, it will add a million key-value pairs to both the Objective-C and ClojureScript maps and report the total times for each in seconds.
