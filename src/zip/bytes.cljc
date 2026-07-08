(ns zip.bytes
  "Portable read cursor over a sequence of unsigned byte values (0-255).
   Pure cljc. Self-contained copy of the primitive kasane.bytes provides —
   duplicated deliberately so this repo has zero kotoba-lang dependencies
   beyond org-ietf-deflate.")

(defn bytes->ascii
  "Interpret a seq of unsigned bytes as an ASCII/Latin-1 string."
  [bs]
  (apply str (map char bs)))
