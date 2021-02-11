package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/publisher/add/{name}")
    @ResponseBody
    public String addPublisher(@PathVariable String name) {

        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.create(publisher);

        return "Created: " + publisher.getId() + ", Name: '" + publisher.getName() + "'";
    }

    @GetMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable Long id,
                               @PathVariable String name) {
        Publisher publisher = this.publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);

        return "Updated: " + publisher.toString();
    }

    @GetMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);

        return publisher.toString();
    }

    @GetMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.deleteById(id);

        return "Deleted: " + publisher.getId() + ", Name: '" + publisher.getName() + "'";
    }
}
