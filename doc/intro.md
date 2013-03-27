# Introduction to clover

Clover is a "dynamic website builder/runner" thing.

## Content

* Put your content in content in a txt file under clover/content folder.
* The name/path of the file will be the URL e.g. home.txt -> /home, /blog/one.txt -> /blog/one etc.
* Each text file should contain "key/value" pairs and seperated by "----". See the home.txt for examples.

## Templates
* Templates are rendered by StringTemplate library.
* The keys that you specify in the content can be rendered in the template using `$KEY_NAME$`
* Each "content file" is rendered using a template and the template is picked up from clover/teamplates folder using the following order of priority
  * NAME_OF_THE_CONTENT_FILE.st
  * default.st (in the matching folder)
  * defaut.st in root  (clover/templates) folder
