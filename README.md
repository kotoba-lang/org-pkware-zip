# kotoba-lang/org-pkware-zip

Zero-dep-beyond-`org-ietf-deflate` portable `.cljc` ZIP container decoder
(PKWARE APPNOTE.TXT spec). Named `org-pkware-zip` — PKWARE still publishes
and maintains APPNOTE.TXT, same `org-<vendor>-<spec>` pattern as
`org-adobe-tiff`/`org-compuserve-gif` (a published spec exists even though
the publisher is a vendor rather than a formal standards body).

Extracted from `kotoba-lang/kasane` (kasane.zip, ADR-2606272100). Reads the
central directory and inflates each member (ZIP uses *raw* DEFLATE, so
`org-ietf-deflate`'s `inflate-raw`). Sketch (`.sketch`), OOXML
(`.docx`/`.xlsx`/`.pptx`), ODF, and EPUB are all ZIP containers — downstream
consumers like `org-w3-epub` and `org-oasis-odf` take this repo's entry
table and do their own semantic (JSON/XML) parsing.

## Usage

```clojure
(require '[zip.core :as zip])

(def entries (zip/parse zip-bytes))   ; => [{:name :method :size :bytes} ...]
(zip/names entries)                   ; => ["a.txt" "b.json" ...]
(zip/entry entries "a.txt")           ; => {:name "a.txt" :method 0 :size N :bytes [...]}
```

## Test

```sh
clojure -M:test
```
