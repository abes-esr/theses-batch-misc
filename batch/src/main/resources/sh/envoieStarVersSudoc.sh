

cd /home/batch/thesesBatch/current

if [[ $(pgrep -cf "thesesBatch.jar --batch_bdd") = 0 ]];
java -Djava.security.egd=file:///dev/urandom -jar thesesBatch.jar --batch_bdd=true 1>/proc/1/fd/1 2>/proc/1/fd/2
if
