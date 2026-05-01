FROM jenkins/jenkins:lts
USER root
# Install dependencies for gcloud
RUN apt-get update && apt-get install -y curl python3
# Install the Google Cloud SDK
RUN curl https://sdk.cloud.google.com | bash
ENV PATH $PATH:/root/google-cloud-sdk/bin
USER jenkins
