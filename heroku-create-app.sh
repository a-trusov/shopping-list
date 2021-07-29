#!/usr/bin/env sh

heroku apps:create hopping-list
heroku addons:create heroku-postgresql:hobby-dev --app hopping-list