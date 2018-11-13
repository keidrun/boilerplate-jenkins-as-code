job('Clean up Docker Job') {
  triggers {
    scm('@midnight')
  }

  steps {
    shell('docker system prune -af')
  }
}
