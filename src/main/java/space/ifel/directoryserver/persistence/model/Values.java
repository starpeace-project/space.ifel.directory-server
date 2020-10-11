/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.ifel.directoryserver.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Daniel Filho
 */
@Entity
@Table(name = "tbl_Values", catalog = "FiveDS", schema = "dbo")
@Data
@NoArgsConstructor
public class Values implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Kind")
    private short kind;
    @Basic(optional = false)
    @Column(name = "Value")
    private String value;
    @Lob
    @Column(name = "bigText")
    private String bigText;
    @Basic(optional = false)
    @Column(name = "size")
    private int size;
    @Basic(optional = false)
    @Column(name = "is_secured")
    private boolean isSecured;
    @JoinColumn(name = "parent_key_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Keys parentKeyId;

}
