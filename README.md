# Gomoku

Gomoku game with computer player

## Overview

FIXME: Write a paragraph about the library/project and highlight its goals.

## Running the program

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## Publishing to Github Pages

lein run -m clojure.main script/publish.clj

View at [http://ericlavigne.github.io/gomoku](http://ericlavigne.github.io/gomoku).

## License

Copyright © 2016 Eric Lavigne
