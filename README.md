persistent-objc-cljs
====================

A project that compares performance of Anton Astashov's [persistent Obj-C collections](https://github.com/astashov/persistent.objc) with ClojureScript's.

Running
=======

Go into the ClojureScript subdirectory and do a `lein cljsbuild once rel`. Then, you can run the iOS project (`open PersistentPerf.xcodeproj` in the `iOS` directory). 

If you tap on the "Run Tests" button, it will add a million key-value pairs to both Objective-C and ClojureScript maps (using transients) and report the total times for each in seconds.

The Objective-C loop is:

```objective-c
-(void)runTests
{
    AAPersistentHashMap *v = [AAPersistentHashMap empty];
    v = [v withTransient:^(AATransientHashMap *transient) {
        for (int i = 0; i < 1000000; i += 1) {
            transient = [transient setObject:[NSNumber numberWithInt:i] 
                                      forKey:[NSNumber numberWithInt:i]];
        }
        return transient;
    }];
}
```

The ClojureScript loop is:

```clojure
(defn- run-cljs-test []
  (loop [i 0
         m (transient {})]
    (if (< i 1000000)
      (recur (inc i)
             (conj! m [i i]))
      (persistent! m))))
```
