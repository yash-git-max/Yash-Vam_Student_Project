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
                   $MAVEN_HOME/bin/mvn sonar:sonar \
                   -Dsonar.projectKey=first_web_project \
                   -Dsonar.projectName=first_web_project \
                   -Dsonar.java.binaries=target
               '''
           }
       }
   }

        stage('Docker Build') {
            steps {
                sh '''
                    docker build -t first-web-app:latest .
                '''
            }
        }


        stage('Docker Deploy') {
            steps {
                sh '''
                    docker stop first-web-app || true
                    docker rm first-web-app || true
                    docker run -d \
                      --name first-web-app \
                      -p 8080:8080 \
                      first-web-app:latest
                '''
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
