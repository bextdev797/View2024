# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.brandonang.buttons2024view.Buttons2024View {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/brandonang/buttons2024view/repack'
-flattenpackagehierarchy
-dontpreverify
