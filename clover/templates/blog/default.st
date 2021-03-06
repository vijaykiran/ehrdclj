<!DOCTYPE html>
<!--[if IE 8]>         <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>$title$ &rarr; $contentTitle$</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:700,400' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/css/normalize.css" />
    <link rel="stylesheet" href="/css/app.css" />
    <script src="/js/vendor/custom.modernizr.js"></script>
    <script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>
  </head>

  <body>
    <div class="row">
      <div class="large-12 columns">
        <div class="large-3 columns">
          <img src="/images/ehrd.png"/>
        </div>

        <!-- Navigation -->
        <div class="large-9 columns">
          <ul class="button-group right">
            <li><a href="/home" class="button">Home</a></li>
            <li><a href="/blog" class="button">Blog</a></li>
            <li><a href="/meetups" class="button">Meetups</a></li>
            <li><a href="/about" class="button">About</a></li>
          </ul>
        </div>
        <hr/>
        <!-- End Navigation -->
        <div class="row">
          <!-- Nav Sidebar -->
          <!-- This is source ordered to be pulled to the left on larger screens -->
          <div class="large-3 columns hide-for-small">
            <iframe width="225" height="570" src="http://meetu.ps/N5VG8" frameborder="0"></iframe>
          </div>
          <!-- Main Blog Content -->
          <div class="large-9 columns" role="content">
            <article>
              <h3><a href="#">$contentTitle$</a></h3>
              <h6>Written by $author$ on $date$.</h6>
              $content$
            </article>

          </div>

          <!-- Footer -->
          <footer class="row">
            <div class="large-12 columns"><hr />
              <div class="row">
                <div class="large-4 columns">
                  <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.en_US"><img alt="Creative Commons License" style="border-width:0" src="/images/cc.png" /></a>
                  <small>$copyright$</small>
                </div>
                <div class="large-6 columns">
                  <ul class="inline-list right">
                    <li><a href="/home">Home</a></li>
                    <li><a href="/blog">Blog</a></li>
                    <li><a href="/meetups">Meetups</a></li>
                    <li><a href="/about">About</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </footer>
          <!-- End Footer -->
        </div>
      </div>
  </body>
</html>
