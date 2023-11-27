package es.anaya.spring.services.s05.batchdb.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.anaya.spring.services.s05.batchdb.domain.Invoice;

import java.util.stream.Stream;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
	@Query("select i from Invoice i inner join i.customer c where i.processed=false")
	
	Stream<Invoice> findPendingInvoicesReturnStream();
    @Modifying
	@Query("UPDATE Invoice i SET i.processed = true WHERE i.processed = false")
	public int markProcessed();
}