Android Chips
=============

Basic chips implementation. Still in very early development, interfaces, names and behaviour may change considerably in upcoming releases.

Ideally this library should follow [material design spec](https://material.google.com/components/chips.html#) but most of the details are
 still not implemented.


![alt tag](https://raw.githubusercontent.com/Tengio/android-chips/master/resources/chips.jpg)


Version
-------

[ ![Download](https://api.bintray.com/packages/tengioltd/maven/android-chips/images/download.svg) ](https://bintray
.com/tengioltd/maven/android-chips/_latestVersion)


HOW TO
======

Dependencies
------------

```
dependencies {
    ...
    compile('com.tengio.android:chips:latest_version')
    ...
}
```

By adding locations library dependency you will automatically get the following dependencies:

```
compile 'com.android.support:appcompat-v7:25.0.0'
compile 'com.android.support:design:25.0.0'
```


Layouts
-------
Add ChipsView to the layout, like this:

```
<com.tengio.android.chips.ChipsView android:id="@+id/custom_chips"
                                    android:layout_width="match_parent"
                                    android:layout_height="wrap_content"/>
```

When you get a reference to the ChipsView you can add a list of Chips (Interface for any kind of model that you want to pass through).

```
chipsView.setItems(chipList);
```

You can also register listeners to receive callbacks when chips are removed from the list.

```
chipsView.setOnChipRemovedListener(new OnChipRemovedListener() {
    @Override
    public void onRemoved(Chip chip) {

    }
});
```


Library updates
---------------

We use bintray to deploy changes to jcenter. To deploy a new version make sure to define BINTRAY_USER and BINTRAY_KEY variables. Then run:

```
gradle bintrayUpload
```