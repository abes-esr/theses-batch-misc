

cd /home/batch/thesesBatch/current

java -Djava.security.egd=file:///dev/urandom -jar thesesBatch.jar --idThese=$1 >> ../logs/batch_single.log &
