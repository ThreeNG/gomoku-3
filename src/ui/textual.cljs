(ns ui.textual
  (:require [ai.game :as game]
            [ai.gomoku :as gomoku]
            [ui.clock :refer [clock seconds-passed]]
            [rum.core :as rum]
            [ai.random-player :as player]))

(defonce board (atom (gomoku/empty-board 3 3)))

(defonce last-move-time (atom @clock))

(defn pause-seconds []
  (if (game/finished? @board)
    3 1))

(defn time-to-update-board? []
  (< (pause-seconds)
     (seconds-passed @last-move-time @clock)))

(defn update-board []
  (reset! board
          (if (game/finished? @board)
            (gomoku/empty-board 3 3)
            (game/play @board (player/play @board))))
  (reset! last-move-time @clock))

(defn render-game-result []
  (when (game/finished? @board)
    [:p [:b (if-let [winner (game/who-won @board)]
              (str ({:x "X" :o "O"} winner)
                   " won!")
              "Tie Game")]]))

(defn render-board []
  [:p (str "Pieces: " (:pieces @board))])

(defn render []
  [:div
   (render-board)
   (render-game-result)])

(rum/defc gomoku-app < rum/reactive []
  (rum/react clock)
  (when (time-to-update-board?)
    (update-board))
  (render))
