package ejb;

import lombok.*;
import orm.models.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * This class represents my first ejb-bean.
 * @author Svyatoslav Sabirov.
 * @since 17.11.2018
 * @version 7.
 */
@Stateless
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserBean {

    // Будет инициализирован контейнером Glassfish
    // unitName = "DEVMODE" - это имя persistence-unit
    // EntityManager дает возможность выполнять CRUD запросы в БД
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    // Добавляем User-а В базу данных
    public User add(final User user) {
        return em.merge(user);
    }

    // Получаем пользователя по id
    public User get(final long id) {
        return em.find(User.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(final User user) {
        em.merge(user);
    }

    // удаляем User по id
    public void delete(final long id) {
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<User> getAll() {
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
}
