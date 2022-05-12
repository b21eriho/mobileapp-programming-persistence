
# Report



```
function errorCallback(error) {
ContentValues values = new ContentValues();
values.put(DataBaseHelper.COLLUMN_NAME, String.valueOf(nameInput.getText()));
values.put(DataBaseHelper.COLLUMN_BRAND, String.valueOf(brandInput.getText()));
values.put(DataBaseHelper.COLLUMN_NR_WHEELS, String.valueOf(nrWheelsInput.getText()));
db.getWritableDatabase().insert(DataBaseHelper.TABLE_BIKE, null, values);
```

![](Screenshot.png)