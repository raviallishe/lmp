(function($) {
    // Each call to this function is only responsible for the function of a carousel
    // In other words, only one carousel image will be generated, and the scope of this function can only be assigned to one carousel image
    // It is required to pass the root label of the current carousel when calling this function
    // The formal parameter ele here is the root label of a carousel
    var slide = function(ele,options) {
        var $ele = $(ele);
        // default setting options
        var setting = {
        	// Control the animation time of the carousel
            speed: 1000,
            // Control the interval time (rotation speed)
            interval: 4000,

        };
        // Object merge
        $.extend(true, setting, options);
        // Specify the location and status of each picture
        var states = [
            { $zIndex: 1, width: 0, height: 0, top: 170, left: 134, $opacity: 0 },
            { $zIndex: 2, width: 0, height: 0, top: 250, left: 80, $opacity: 0 },
            { $zIndex: 4, width: 390, height: 390, top: 80, left: 80, $opacity: 0.7 },
            { $zIndex: 5, width: 560, height: 560, top: 0, left: 380, $opacity: 1 },
            { $zIndex: 4, width: 390, height: 390, top: 80, left: 780, $opacity: 0.7 },
            { $zIndex: 2, width: 0, height: 0, top: 250, left: 920, $opacity: 0 },
            { $zIndex: 1, width: 0, height: 0, top: 170, left: 600, $opacity: 0 }
        ];

        var $lis = $ele.find('li');
        var timer = null;

        // event
        $ele.find('.hi-next').on('click', function() {
            next();
        });
        $ele.find('.hi-prev').on('click', function() {
            states.push(states.shift());
            move();
        });
        $ele.on('mouseenter', function() {
            clearInterval(timer);
            timer = null;
        }).on('mouseleave', function() {
            autoPlay();
        });

        move();
        autoPlay();

        // Let each li correspond to each state of the above states
        // Let li expand from the middle
        function move() {
            $lis.each(function(index, element) {
                var state = states[index];
                $(element).css('zIndex', state.$zIndex).finish().animate(state, setting.speed).find('img').css('opacity', state.$opacity);
            });
        }

        // Switch to next
        function next() {
            // Principle: Move the last element of the array to the first
            states.unshift(states.pop());
            move();
        }

        function autoPlay() {
            timer = setInterval(next, setting.interval);
        }
    }
    // Find the root label of the carousel to be rotated, and call slide ()
    $.fn.hiSlide = function(options) {
        $(this).each(function(index, ele) {
            slide(ele,options);
        });
        // Return value to support chained calls
        return this;
    }
})(jQuery);
