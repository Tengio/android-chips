#!/bin/bash

echo "Installing code style configs..."

for i in $HOME/Library/Preferences/IntelliJIdea*  \
         $HOME/Library/Preferences/IdeaIC*        \
         $HOME/Library/Preferences/AndroidStudio* \
         $HOME/.IntelliJIdea*/config              \
         $HOME/.IdeaIC*/config                    \
         $HOME/.AndroidStudio*/config
do
  if [ -d $i ]; then
    mkdir -p $i/codestyles
    cp -frv chips.xml $i/codestyles
  fi
done

echo "Done, restart IDE"