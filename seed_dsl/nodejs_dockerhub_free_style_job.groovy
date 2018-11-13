job('NodeJS Basic Job With DockerHub') {
  scm {
    git('https://github.com/keidrun/target_repo.git') {  node ->
      node / gitConfigName('DSL User')
      node / gitConfigEmail('jenkins-dsl@example.com')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  wrappers {
    nodejs('nodejs_v11')
  }
  steps {
    shell('npm install')
    shell('npm test')
  }
  // "CloudBees Docker Build and Publish" plugin required
  steps {
    dockerBuildAndPublish {
      repositoryName('keidrun/target-repo')
      tag('${GIT_REVISION,length=9}')
      registryCredentials('dockerhub') // Needs credential for DocerHub
      forcePull(false)
      forceTag(false)
      createFingerprints(false)
      skipDecorate()
    }
  }
}
