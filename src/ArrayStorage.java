import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int storageSize;

    public void clear() {
        Arrays.fill(storage, 0, storageSize, null);
    }

    public void save(Resume resume) {
        if (storageSize < storage.length) {
            storage[storageSize] = resume;
            storageSize++;
        } else {
            System.out.println("Массив переполнен и новая запись невозможна");
        }
    }

    public Resume get(String uuid) {
        Integer index = getIndexByIdentifier(uuid);
        if (index != null) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        Integer index = getIndexByIdentifier(uuid);
        if (index != null) {
            storageSize--;
            storage[index] = storage[storageSize];
            storage[storageSize] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, storageSize);
    }

    public int size() {
        return storage.length;
    }

    private Integer getIndexByIdentifier(String uuid) {
        int numberOfResumes = 0;
        int index = 0;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getIdentifier().equals(uuid)) {
                numberOfResumes++;
                index = i;
            }
        }
        if (numberOfResumes == 1) {
            return index;
        } else {
            if (numberOfResumes == 0) {
                System.out.println("Не найдено резюме с идентификатором " + uuid);
            } else {
                System.out.println("Найдено несколько резюме с идентификатором " + uuid);
            }
        }
        return null;
    }
}
