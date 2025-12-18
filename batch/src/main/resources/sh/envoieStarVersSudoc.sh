

cd /home/batch/thesesBatch/current

if [[ $(pgrep -cf "thesesBatch.jar --batch_bdd") = 0 ]];
java -Djava.security.egd=file:///dev/urandom -jar thesesBatch.jar --batch_bdd=true >> ../logs/batch_single.log
if
