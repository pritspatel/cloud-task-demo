This sample is about using spring cloud task and spring batch job. Cloud task is launching a spring batch job with single step.

How to run locally
-----------------

1. Just run the CloudTaskDemoApplication


How to run on cloud foundry
---------------------------

1. Deploy app in cloud foundry with following command

cf push cloud-task-demo --no-route --health-check-type none -p target/cloud-task-demo-0.0.1-SNAPSHOT.jar

2. Check logs and you should see following statement in the logs

*******  Job1 was run *******

3. Now to setup a job schedule, login to your run.pivotal.io and click on the deployed apps

4. Go to "Tasks" and click on "Enable schduling"

5. Then click on "Create Job" and fill in the following 3 items

    1. Name of the job "test-job"
    2. command : JAVA_OPTS="-agentpath:$PWD/.java-buildpack/open_jdk_jre/bin/jvmkill-1.10.0_RELEASE=printHeapHistogram=1 -Djava.io.tmpdir=$TMPDIR -Djava.ext.dirs=$PWD/.java-buildpack/container_security_provider:$PWD/.java-buildpack/open_jdk_jre/lib/ext -Djava.security.properties=$PWD/.java-buildpack/security_providers/java.security $JAVA_OPTS" && CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-3.9.0_RELEASE -totMemory=$MEMORY_LIMIT -stackThreads=300 -loadedClasses=13250 -poolType=metaspace -vmOptions="$JAVA_OPTS") && echo JVM Memory Configuration: $CALCULATED_MEMORY && JAVA_OPTS="$JAVA_OPTS $CALCULATED_MEMORY" && SERVER_PORT=$PORT eval exec $PWD/.java-buildpack/open_jdk_jre/bin/java $JAVA_OPTS -cp $PWD/. org.springframework.boot.loader.JarLauncher
    3. cron expression : 5 * * * ? (Every 5 min)


