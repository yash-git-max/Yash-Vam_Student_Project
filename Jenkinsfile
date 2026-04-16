pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

stages {

    stage('Build') {
        steps {
            sh '''
                echo "Using explicitly configured JDK"
                echo "JAVA_HOME=$JAVA_HOME"
                $JAVA_HOME/bin/java -version

                echo "Maven using this Java:"
                $JAVA_HOME/bin/java -version
                $MAVEN_HOME/bin/mvn -version

                $MAVEN_HOME/bin/mvn clean package
            '''
        }
    }

    stage('SonarQube Analysis') {
        steps {
            withSonarQubeEnv('SonarQube') {
                sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=first_web_project \
                    -Dsonar.projectName=first_web_project \
                    -Dsonar.branch.name=master \
                    -Dsonar.java.binaries=target
                '''
            }
        }
    }
}


    post {
        success {
            echo 'Build completed successfully'
        }
        failure {
            echo 'Build failed'
        }
    }
}
