// Generated code from Butter Knife. Do not modify!
package csc4444.mike.dreamlink;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends csc4444.mike.dreamlink.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558537, "field 'mainToolbar'");
    target.mainToolbar = finder.castView(view, 2131558537, "field 'mainToolbar'");
    view = finder.findRequiredView(source, 2131558503, "field 'navDrawerLayout'");
    target.navDrawerLayout = finder.castView(view, 2131558503, "field 'navDrawerLayout'");
    view = finder.findRequiredView(source, 2131558504, "field 'navDrawerList'");
    target.navDrawerList = finder.castView(view, 2131558504, "field 'navDrawerList'");
  }

  @Override public void unbind(T target) {
    target.mainToolbar = null;
    target.navDrawerLayout = null;
    target.navDrawerList = null;
  }
}
