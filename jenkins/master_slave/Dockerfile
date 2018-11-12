FROM jenkins

USER root
RUN cd tmp/ \
  && wget https://updates.jenkins-ci.org/latest/jenkins.war \
  && mv ./jenkins.war /usr/share/jenkins/

USER jenkins
