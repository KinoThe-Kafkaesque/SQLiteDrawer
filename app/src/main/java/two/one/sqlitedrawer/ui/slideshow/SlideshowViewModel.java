package two.one.sqlitedrawer.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import two.one.sqlitedrawer.MainActivity;
import two.one.sqlitedrawer.classes.Marque;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<List<Marque>> marques  ;

    public SlideshowViewModel() {
        marques = new MutableLiveData<>();
        marques.setValue(MainActivity.marqueService.findAll());
    }

    public LiveData<List<Marque>> get() {
        return marques;
    }
}