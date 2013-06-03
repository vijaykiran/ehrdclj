<!DOCTYPE html>
<!--[if IE 8]>         <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width" />
    <title>$title$</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:700,400' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/app.css" />
    <script src="js/vendor/custom.modernizr.js"></script>
    <script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>
  </head>

  <body>
    <div class="row">
      <div class="large-12 columns">

        <div class="large-3 columns">
          <img src="images/ehrd.png"/>
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

        <!-- End Navigation -->
        <hr/>
        <!-- Header Content -->
        <div class="row">

          <div class="large-6 columns hide-for-small">
            <img src="images/meetup.png" />
          </div>

          <div class="large-6 columns">

            <h3 class="show-for-small">Welcome to EHRD.clj!<hr/></h3>

            <div class="panel">
               $introTextBlock$
            </div>
          </div>
        </div>
        <!-- End Header Content -->

        <div class="row">
          <div class="large-4 hide-for-small columns">
            <div class="panel radius">
              <h5>What's happening </h5>
              <p>We post regular updates about our meetup on our <a href="/blog">blog</a>, which also features posts written by our members about the topics we discuss during the meetup.</p>
              <a href="/blog" class="small button radius">Read our blog!</a>
            </div>
          </div>

          <div class="large-4 small-12 columns">
            <div class="panel radius">
              <h5>Upcoming Meetup</h5>
              <h6 class"subheader">init.clj - The fourth meetup</h6>
              <h6 class="subheader">Wednesday 26th Jun, 2013 19:00 - 21:30</h6>
              <h6 class="subheader"><a href="http://lunatech.com" target="_blank">Lunatech</a>, Heemraadssingel 70, Rotterdam</h6>
              <a href="http://www.meetup.com/ehrd-clj/events/106662772/" data-event="106662772"  class="small button radius alert mu-rsvp-btn" target="_blank">RSVP</a>
            </div>
          </div>

          <div class="large-4 small-12 columns">
            <div class="panel radius">
              $sponsors$
            </div>
          </div>

        </div>

        <!-- Footer -->
        <footer class="row">
          <div class="large-12 columns"><hr />
            <div class="row">
              <div class="large-4 columns">
                <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.en_US"><img alt="Creative Commons License" style="border-width:0" src="images/cc.png" /></a>
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
