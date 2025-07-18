

cd /home/batch/thesesBatch/current

java -Djava.security.egd=file:///dev/urandom -jar thesesBatch.jar --idThese=$1 1>/proc/1/fd/1 2>/proc/1/fd/2
