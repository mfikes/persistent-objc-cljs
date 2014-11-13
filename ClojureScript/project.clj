(defproject persistent-perf "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
                           [org.clojure/clojurescript "0.0-2371"]
                           [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                           [weasel "0.4.0-SNAPSHOT"]]
            :plugins [[lein-cljsbuild "1.0.3"]
                      [jarohen/simple-brepl "0.1.1"]]
            :source-paths ["goby-src"
                           "src"]
            :brepl {:ip "127.0.0.1"}
            :cljsbuild {:builds {:dev
                                  {:source-paths ["goby-src"
                                                  "src"
                                                  "dev-src"]
                                   :compiler     {:output-to     "js/main.js"
                                                  :optimizations :whitespace
                                                  :static-fns    false
                                                  :externs       ["goby-externs.js" "externs.js"]
                                                  :pretty-print  true}}
                                 :rel
                                  {:source-paths ["goby-src"
                                                  "src"
                                                  "rel-src"]
                                   :compiler     {:output-to     "js/main.js"
                                                  :optimizations :advanced
                                                  :static-fns    true
                                                  :externs       ["goby-externs.js" "externs.js"]
                                                  :pretty-print  false
                                                  :pseudo-names  false}}}})
