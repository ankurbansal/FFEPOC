<script type="text/javascript" src="resources/overlay/jquery.tools.min.js"></script>
<style>

	/* get rid of those system borders being generated for A tags */
	a:active {
		outline:none;
	}

	:focus {
		-moz-outline-style:none;
	}

	/* use a semi-transparent image for the overlay */
	#overlay {
		/*background-image:url(transparent.png);*/
		color:#efefef;
		height:450px;
	}
	/* container for external content. uses vertical scrollbar, if needed */
		div.contentWrap {
		height:630px;
		overflow-y:auto;
	}
	/* the overlayed element */
	
	.apple_overlay {
		/* initially overlay is hidden */
		display:none;

		/* growing background image */
		/*background-image:url(white.png);*/

		/*
		  width after the growing animation finishes
		  height is automatically calculated
		  */
		width:987px;

		/* some padding to layout nested elements nicely  */
		padding:35px;

		/* a little styling */
		font-size:11px;		
	}

	/* default close button positioned on upper right corner */
	.apple_overlay .close {
		background-image:url(resources/images/close.png);
		position:absolute; right:5px; top:5px;
		cursor:pointer;
		height:35px;
		width:35px;
	}
</style>

<!-- external page is given in the href attribute (as it should be) -->
<a href="loadServicePricingEstimateForm" rel="#overlay" style="text-decoration:none">
  <button type="button">Show external page in overlay</button>
</a>
<div class="apple_overlay" id="overlay">
  <div class="contentWrap"></div>
</div>
	
<script>
$(function() {

    // if the function argument is given to overlay,
    // it is assumed to be the onBeforeLoad event listener
    $("a[rel]").overlay({

        mask: 'darkgrey',
        effect: 'apple',

        onBeforeLoad: function() {
            // grab wrapper element inside content
            var wrap = this.getOverlay().find(".contentWrap");

            // load the page specified in the trigger
            wrap.load(this.getTrigger().attr("href"));
        }

    });
});
</script>
